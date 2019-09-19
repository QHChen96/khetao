package com.khetao.serve.shop.controller.product;

import com.khetao.auth.annotation.CurrentUser;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.dto.product.CategoryCustomDTO;
import com.khetao.serve.shop.service.CategoryCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/category/custom")
public class CategoryCustomController extends BaseController {

    @Autowired
    private CategoryCustomService categoryCustomService;

    @GetMapping("/list")
    public BaseResult listCategory() {
        return success(categoryCustomService.list(null));
    }

    @PostMapping("/save")
    public BaseResult saveCategory(@CurrentUser Long userId, @RequestBody CategoryCustomDTO categoryDTO) {
        categoryDTO.setUserId(userId);
        return success(categoryCustomService.saveCategory(categoryDTO));
    }

    @GetMapping("/delete")
    public BaseResult deleteCategory(@CurrentUser Long userId, @RequestParam Long id) {
        return success(categoryCustomService.delCategory(id, userId));
    }

}
