package com.jnshu.dreamteam.mapper;

import com.jnshu.dreamteam.pojo.PhoneVerification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzp
 * @since 2019-03-13
 */
public interface PhoneVerificationMapper extends BaseMapper<PhoneVerification> {

    void phoneVerification(PhoneVerification phoneVerification);

}
