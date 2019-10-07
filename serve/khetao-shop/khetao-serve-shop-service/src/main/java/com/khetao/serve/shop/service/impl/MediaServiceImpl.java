package com.khetao.serve.shop.service.impl;

import com.khetao.base.service.BaseServiceImpl;
import com.khetao.serve.shop.entity.Media;
import com.khetao.serve.shop.mapper.MediaMapper;
import com.khetao.serve.shop.service.MediaService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
    * 媒体表 服务实现类
    * </p>
 *
 * @author chenqinhao
 * @email qhchen96@gmail.com
 * @since 2019-09-20
 * @version 1.0
 */
@Service
public class MediaServiceImpl extends BaseServiceImpl<MediaMapper, Media> implements MediaService {

    @Override
    public Long insertMedia(Media media) {
        media.setGmtCreate(LocalDateTime.now());
        media.setGmtModify(LocalDateTime.now());
        baseMapper.insert(media);
        return media.getId();
    }
}
