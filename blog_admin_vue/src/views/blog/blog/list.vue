<template>
  <a-card :bordered="false" class="card-area">
    <div :class="advanced ? 'search' : null">
      <!-- 搜索区域 -->
      <a-form layout="horizontal">
        <div :class="advanced ? null: 'fold'">
          <a-row>
            <a-col :md="6" :sm="24">
              <a-form-item
                label="状态"
                :labelCol="{span: 5}"
                :wrapperCol="{span: 18, offset: 1}">
                <a-select allowClear defaultValue="" style="width: 120px" @change="handleChange">
                  <a-select-option value="0">草稿</a-select-option>
                  <a-select-option value="1">已发布</a-select-option>
                  <a-select-option value="2">已删除</a-select-option>
                </a-select>
              </a-form-item>
            </a-col>
            <a-col :md="12" :sm="24">
              <a-form-item
                label="标题"
                :labelCol="{span: 5}"
                :wrapperCol="{span: 18, offset: 1}">
                <a-input v-model="queryParams.title"/>
              </a-form-item>
            </a-col>
          </a-row>
        </div>
        <span style="float: right; margin-top: 3px;">
          <a-button type="primary" @click="search">查询</a-button>
          <a-button style="margin-left: 8px" @click="reset">重置</a-button>
        </span>
      </a-form>
    </div>
    <div>
      <div class="operator">
        <a-button v-hasPermission="['dept:add']" type="primary" ghost @click="add">新增</a-button>
        <a-button v-hasPermission="['dept:delete']" @click="batchDelete">删除</a-button>
        <a-dropdown v-hasPermission="['dept:export']">
          <a-menu slot="overlay">
            <a-menu-item key="export-data" @click="exportExcel">导出Excel</a-menu-item>
          </a-menu>
          <a-button>
            更多操作
            <a-icon type="down"/>
          </a-button>
        </a-dropdown>
      </div>
      <!-- 表格区域 -->
      <a-table ref="TableInfo"
               :columns="columns"
               :rowKey="record => record.dictId"
               :dataSource="dataSource"
               :pagination="pagination"
               :loading="loading"
               :scroll="{ x: 900 }"
               :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
               @change="handleTableChange">
        <template slot="summary" slot-scope="text, record">
          <a-popover placement="topLeft">
            <template slot="content">
              <div>{{text}}</div>
            </template>
            <p style="width: 150px;margin-bottom: 0">{{text}}</p>
          </a-popover>
        </template>
        <template slot="operation" slot-scope="text, record">
          <a-icon v-hasPermission="['user:update']" type="setting" theme="twoTone" twoToneColor="#4a9ff5" @click="edit(record)" title="修改用户"></a-icon>
          &nbsp;
          <a-icon v-hasPermission="['user:view']" type="eye" theme="twoTone" twoToneColor="#42b983" @click="view(record)" title="查看"></a-icon>
          <a-badge v-hasNoPermission="['user:update','user:view']" status="warning" text="无权限"></a-badge>
        </template>
      </a-table>
    </div>
  </a-card>
</template>

<script>
  import {getBlogs} from '@/api/blog'

  export default {
    name: "",

    components: {},

    mounted() {
      this.fetch()
    },
    computed: {
      columns() {
        let {sortedInfo} = this
        sortedInfo = sortedInfo || {}
        return [{
          title: '序号',
          dataIndex: 'id'
        }, {
          title: '标题',
          dataIndex: 'title'
        }, {
          title: '概要',
          dataIndex: 'summary',
          width: '50px',
          scopedSlots: {customRender: 'summary'},
        }, {
          title: '阅读数',
          dataIndex: 'viewCount',
          sorter: true,
          sortOrder: sortedInfo.columnKey === 'modifyTime' && sortedInfo.order
        }, {
          title: '创建时间',
          dataIndex: 'createTime',
          sorter: true,
          sortOrder: sortedInfo.columnKey === 'modifyTime' && sortedInfo.order
        }, {
          title: '修改时间',
          dataIndex: 'updateTime',
          sorter: true,
          sortOrder: sortedInfo.columnKey === 'modifyTime' && sortedInfo.order
        }, {
          title: '操作',
          dataIndex: 'operation',
          scopedSlots: {customRender: 'operation'},
          fixed: 'right',
          width: 120
        }]
      }
    },
    data() {
      return {
        advanced: false,
        queryParams: {},
        selectedRowKeys: [],
        sortedInfo: null,
        dataSource: [],
        paginationInfo: null,
        pagination: {
          pageSizeOptions: ['10', '20', '30', '40', '100'],
          defaultCurrent: 1,
          defaultPageSize: 10,
          showQuickJumper: true,
          showSizeChanger: true,
          showTotal: (total, range) => `显示 ${range[0]} ~ ${range[1]} 条记录，共 ${total} 条记录`
        },
        loading: false,
        deptAddVisiable: false,
        deptEditVisiable: false

      };
    }, methods: {
      onSelectChange(selectedRowKeys) {
        this.selectedRowKeys = selectedRowKeys
      },
      handleChange(value) {
        console.log(`selected ${value}`);
      }, handleDateChange(value) {
        console.log(`selected`);
      }, search() {

      }, reset() {

      }, add() {
        this.deptAddVisiable = true
      }, batchDelete() {
        if (!this.selectedRowKeys.length) {
          this.$message.warning('请选择需要删除的记录')
          return
        }
        let that = this
        this.$confirm({
          title: '确定删除所选中的记录?',
          content: '当您点击确定按钮后，这些记录将会被彻底删除，如果其包含子记录，也将一并删除！',
          centered: true,
          onOk() {
            that.$delete('dept/' + that.selectedRowKeys.join(',')).then(() => {
              that.$message.success('删除成功')
              that.selectedRowKeys = []
              that.fetch()
            })
          },
          onCancel() {
            that.selectedRowKeys = []
          }
        })
      },
      exportExcel() {
        let {sortedInfo} = this
        let sortField, sortOrder
        // 获取当前列的排序和列的过滤规则
        if (sortedInfo) {
          sortField = sortedInfo.field
          sortOrder = sortedInfo.order
        }
        this.$export('dept/excel', {
          sortField: sortField,
          sortOrder: sortOrder,
          ...this.queryParams
        })
      },
      handleTableChange(pagination, filters, sorter) {
        this.paginationInfo = pagination
        this.fetch({
          ...this.queryParams
        })
      },
      fetch(params = {}) {
        // 显示loading
        this.loading = true
        if (this.paginationInfo) {
          // 如果分页信息不为空，则设置表格当前第几页，每页条数，并设置查询分页参数
          this.$refs.TableInfo.pagination.current = this.paginationInfo.current
          this.$refs.TableInfo.pagination.pageSize = this.paginationInfo.pageSize
          params.pageSize = this.paginationInfo.pageSize
          params.pageNum = this.paginationInfo.current
        } else {
          // 如果分页信息为空，则设置为默认值
          params.pageSize = this.pagination.defaultPageSize
          params.pageNum = this.pagination.defaultCurrent
        }
        getBlogs({
          ...params
        }).then((r) => {
          const pagination = {...this.pagination}
          let data = r.data.data
          pagination.total = data.total
          this.loading = false
          this.dataSource = data.rows
          this.pagination = pagination
        })
      },
      edit (record) {
        this.$refs.userEdit.setFormValues(record)
        this.userEdit.visiable = true
      },
    }
  }
</script>

<style lang="less" scoped>
  @import "../../../../static/less/Common";

</style>

