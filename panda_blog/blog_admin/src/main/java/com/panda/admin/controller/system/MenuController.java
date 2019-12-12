package com.panda.admin.controller.system;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.panda.exception.PandaException;
import com.panda.manage.UserManager;
import com.panda.pojo.blog.Menu;
import com.panda.pojo.router.VueRouter;
import com.panda.service.MenuService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wl
 * @Date: 2019/12/6 16:18
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/panda/menu")
public class MenuController {

    private String message;

    @Autowired
    private UserManager userManager;

    @Autowired
    private MenuService menuService;

    @GetMapping("/{username}")
    public ArrayList<VueRouter<Menu>> getUserRouters(@PathVariable String username) {
        return this.userManager.getUserRouters(username);
    }

    @GetMapping
    @RequiresPermissions("menu:view")
    public Map<String, Object> menuList(Menu menu) {
        return this.menuService.findMenus(menu);
    }

    @PostMapping
    @RequiresPermissions("menu:add")
    public void addMenu(@Valid Menu menu) throws PandaException {
        try {
            this.menuService.createMenu(menu);
        } catch (Exception e) {
            message = "新增菜单/按钮失败";
            log.error(message, e);
            throw new PandaException(message);
        }
    }

    @DeleteMapping("/{menuIds}")
    @RequiresPermissions("menu:delete")
    public void deleteMenus(@NotBlank(message = "{required}") @PathVariable String menuIds) throws PandaException {
        try {
            String[] ids = menuIds.split(StringPool.COMMA);
            this.menuService.deleteMeuns(ids);
        } catch (Exception e) {
            message = "删除菜单/按钮失败";
            log.error(message, e);
            throw new PandaException(message);
        }
    }

    @PutMapping
    @RequiresPermissions("menu:update")
    public void updateMenu(@Valid Menu menu) throws PandaException {
        try {
            this.menuService.updateMenu(menu);
        } catch (Exception e) {
            message = "修改菜单/按钮失败";
            log.error(message, e);
            throw new PandaException(message);
        }
    }

    @PostMapping("excel")
    @RequiresPermissions("menu:export")
    public void export(Menu menu, HttpServletResponse response) throws PandaException {
        try {
            List<Menu> menus = this.menuService.findMenuList(menu);
            ExcelKit.$Export(Menu.class, response).downXlsx(menus, false);
        } catch (Exception e) {
            message = "导出Excel失败";
            log.error(message, e);
            throw new PandaException(message);
        }
    }
}
