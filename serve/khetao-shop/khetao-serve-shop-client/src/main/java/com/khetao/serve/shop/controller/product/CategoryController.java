package com.khetao.serve.shop.controller.product;

import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.consts.UploaderTypeEnum;
import com.khetao.serve.shop.dto.product.CategoryDTO;
import com.khetao.serve.shop.service.CategoryService;
import com.khetao.serve.shop.wrap.MediaWrapService;
import com.khetao.storage.model.StorageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-09-18
 */
@RestController
@RequestMapping("/category")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MediaWrapService mediaWrapService;

    @PostMapping("/img/upload")
    private BaseResult uploadUpload(@CurrentUserId Long userId, @RequestParam("file") MultipartFile multipartFile) {
        StorageResult result = mediaWrapService.uploadCate(multipartFile, userId, UploaderTypeEnum.KHETAO_USER);
        return success(result);
    }

    @GetMapping("/list")
    public BaseResult listCategory() {
        return success(categoryService.list(null));
    }

    @PostMapping("/save")
    public BaseResult saveCategory(@RequestBody CategoryDTO categoryDTO) {
        return success(categoryService.saveCategory(categoryDTO));
    }

    @GetMapping("/delete")
    public BaseResult deleteCategory(@RequestParam Long id) {
        return success(categoryService.delCategory(id));
    }

}
