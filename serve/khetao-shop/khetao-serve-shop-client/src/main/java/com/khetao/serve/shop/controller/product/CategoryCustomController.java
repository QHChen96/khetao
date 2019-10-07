package com.khetao.serve.shop.controller.product;

import com.khetao.auth.annotation.CurrentUserId;
import com.khetao.base.BaseController;
import com.khetao.base.BaseResult;
import com.khetao.serve.shop.consts.UploaderTypeEnum;
import com.khetao.serve.shop.dto.product.CategoryCustomDTO;
import com.khetao.serve.shop.service.CategoryCustomService;
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
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/category/custom")
public class CategoryCustomController extends BaseController {

    @Autowired
    private CategoryCustomService categoryCustomService;

    @Autowired
    private MediaWrapService mediaWrapService;

    @GetMapping("/list")
    public BaseResult listCategory() {
        return success(categoryCustomService.list(null));
    }

    @PostMapping("/save")
    public BaseResult saveCategory(@CurrentUserId Long userId, @RequestBody CategoryCustomDTO categoryDTO) {
        categoryDTO.setUserId(userId);
        return success(categoryCustomService.saveCategory(categoryDTO));
    }

    @GetMapping("/delete")
    public BaseResult deleteCategory(@CurrentUserId Long userId, @RequestParam Long id) {
        return success(categoryCustomService.delCategory(id, userId));
    }

    @PostMapping("/img/upload")
    private BaseResult uploadUpload(@CurrentUserId Long userId, @RequestParam("file") MultipartFile multipartFile) {
        StorageResult result = mediaWrapService.uploadCateCustom(multipartFile, userId, UploaderTypeEnum.KHETAO_USER);
        return success(result);
    }

}
