package com.wang.db;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.domain.ClaimCaseInfo;
import com.wang.mapper.ClaimCaseInfoMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class ShardingSphereJdbcTest {
    @Resource
    private ClaimCaseInfoMapper claimCaseInfoMapper;

    @Test
    public void test() {
        ClaimCaseInfo caseInfo = new ClaimCaseInfo();
        caseInfo.setId(Math.abs(RandomUtil.randomInt()));
        String transactionNo = DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT) + RandomUtil.randomNumbers(10) + "00000000";
        caseInfo.setTransactionNo(transactionNo);
        claimCaseInfoMapper.insert(caseInfo);

        QueryWrapper<ClaimCaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("transaction_no", transactionNo);
        claimCaseInfoMapper.selectOne(queryWrapper);


    }

    public static void main(String[] args) {
        System.out.println(DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_FORMAT));
    }
}
