package com.wang.db;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.domain.ClaimCaseInfo;
import com.wang.domain.IndividualAuthorizationManagement;
import com.wang.mapper.ClaimCaseInfoMapper;
import com.wang.mapper.IndividualAuthorizationManagementMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class ShardingSphereJdbcTest {
    @Resource
    private ClaimCaseInfoMapper claimCaseInfoMapper;
    @Resource
    private IndividualAuthorizationManagementMapper individualAuthorizationManagementMapper;


    @Test
    public void test01() {
        ClaimCaseInfo caseInfo = new ClaimCaseInfo();
        caseInfo.setId(Math.abs(RandomUtil.randomInt()));
        String transactionNo = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT) + RandomUtil.randomNumbers(10) + "00000000";
        caseInfo.setTransactionNo(transactionNo);
        caseInfo.setMobileNo("11111111111");
        claimCaseInfoMapper.insert(caseInfo);

        QueryWrapper<ClaimCaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("transaction_no", transactionNo);
        claimCaseInfoMapper.selectOne(queryWrapper);


    }

    @Test
    public void test02() {
        IndividualAuthorizationManagement management = new IndividualAuthorizationManagement();
        management.setId(Math.abs(RandomUtil.randomInt()));
        String authCode = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT) + RandomUtil.randomNumbers(10) + "00000000";
        management.setAuthCode(authCode);
        individualAuthorizationManagementMapper.insert(management);

        QueryWrapper<IndividualAuthorizationManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("auth_code", authCode);
        individualAuthorizationManagementMapper.selectOne(queryWrapper);



    }


}
