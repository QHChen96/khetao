package com.khetao.serve.shop.service;

import com.khetao.base.service.BaseService;
import com.khetao.serve.shop.entity.Media;

/**
 * <p>
    * 媒体表 服务类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-09-20
 * @version 1.0
 */
public interface MediaService extends BaseService<Media> {

    Long insertMedia(Media media);

}
