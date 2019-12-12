<template>
<div>
  <a-form :form="form">
    <a-form-item label='标题' v-bind="formItemLayout">
      <a-input style="width: 100%"
                      v-decorator="['keyy',
                   {rules: [
                    { required: true, message: '不能为空'}
                  ]}]"/>
    </a-form-item>
    <a-form-item label='分类' v-bind="formItemLayout">
      <a-input v-decorator="['valuee',
                   {rules: [
                    { required: true, message: '不能为空'},
                    { max: 20, message: '长度不能超过20个字符'}
                  ]}]"/>
    </a-form-item>
    <a-form-item label='标签' v-bind="formItemLayout">
      <a-input v-decorator="['tableName',
                   {rules: [
                    { required: true, message: '不能为空'},
                    { max: 20, message: '长度不能超过20个字符'}
                  ]}]"/>
    </a-form-item>
    <a-form-item label='立即发布' v-bind="formItemLayout">
      <a-input v-decorator="['fieldName',
                   {rules: [
                    { required: true, message: '不能为空'},
                    { max: 20, message: '长度不能超过20个字符'}
                  ]}]"/>
    </a-form-item>
    <a-form-item label='概要' v-bind="formItemLayout">
      <a-input v-decorator="['fieldName',
                   {rules: [
                    { required: true, message: '不能为空'},
                    { max: 20, message: '长度不能超过20个字符'}
                  ]}]"/>
    </a-form-item>
    <a-form-item>
      <div id="main" style="width: 118%;">
        <mavon-editor  ref="md" @imgAdd="$imgAdd"  v-model="blog.content" />
      </div>
    </a-form-item>

    <a-form-item v-bind="tailFormItemLayout">
      <a-popconfirm title="确定放弃编辑？" @confirm="onClose" okText="确定" cancelText="取消">
        <a-button style="margin-right: .8rem">取消</a-button>
      </a-popconfirm>
      <a-button @click="handleSubmit" type="primary" :loading="loading">提交</a-button>
    </a-form-item>
  </a-form>

</div>
</template>

<script>
  const residences = [
    {
      value: 'zhejiang',
      label: 'Zhejiang',
      children: [
        {
          value: 'hangzhou',
          label: 'Hangzhou',
          children: [
            {
              value: 'xihu',
              label: 'West Lake',
            },
          ],
        },
      ],
    },
    {
      value: 'jiangsu',
      label: 'Jiangsu',
      children: [
        {
          value: 'nanjing',
          label: 'Nanjing',
          children: [
            {
              value: 'zhonghuamen',
              label: 'Zhong Hua Men',
            },
          ],
        },
      ],
    },
  ];

  export default {
    data() {
      return {
        blog:{},
        confirmDirty: false,
        residences,
        autoCompleteResult: [],
        formItemLayout: {
          labelCol: {
            xs: { span: 14 },
            sm: { span: 3 },
          },
          wrapperCol: {
            xs: { span: 24 },
            sm: { span: 15 },
          },
        },
        tailFormItemLayout: {
          wrapperCol: {
            xs: {
              span: 24,
              offset: 0,
            },
            sm: {
              span: 16,
              offset: 12,
            },
          },
        },
      };
    },
    beforeCreate() {
      this.form = this.$form.createForm(this, { name: 'register' });
    },
    methods: {
      handleSubmit(e) {
        e.preventDefault();
        this.form.validateFieldsAndScroll((err, values) => {
          if (!err) {
            console.log('Received values of form: ', values);
          }
        });
      },
      $imgAdd(pos, $file) {
        // 第一步.将图片上传到服务器.
        var formdata = new FormData();
        formdata.append('image', $file);
        this.img_file[pos] = $file;
        this.$http({
          url: '/api/edit/uploadimg',
          method: 'post',
          data: formdata,
          headers: { 'Content-Type': 'multipart/form-data' },
        }).then((res) => {
          let _res = res.data;
          // 第二步.将返回的url替换到文本原位置![...](0) -> ![...](url)
          this.$refs.md.$img2Url(pos, _res.url);
        })
      },
      handleConfirmBlur(e) {
        const value = e.target.value;
        this.confirmDirty = this.confirmDirty || !!value;
      },
      compareToFirstPassword(rule, value, callback) {
        const form = this.form;
        if (value && value !== form.getFieldValue('password')) {
          callback('Two passwords that you enter is inconsistent!');
        } else {
          callback();
        }
      },
      validateToNextPassword(rule, value, callback) {
        const form = this.form;
        if (value && this.confirmDirty) {
          form.validateFields(['confirm'], { force: true });
        }
        callback();
      },
      handleWebsiteChange(value) {
        let autoCompleteResult;
        if (!value) {
          autoCompleteResult = [];
        } else {
          autoCompleteResult = ['.com', '.org', '.net'].map(domain => `${value}${domain}`);
        }
        this.autoCompleteResult = autoCompleteResult;
      },
    },
  };
</script>
