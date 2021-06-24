package com.zs.erh.service.facade;

import com.zs.erh.service.vo.ChangePwdVo;

public interface AuthService {
    public int changePassword(long id, ChangePwdVo changePwdVo);
}
