package com.itheima.service.impl;
//一对一查询实现类

import com.itheima.bean.Card;
import com.itheima.mapper.OneToOneMapper;
import com.itheima.service.OneToOneService;
import com.itheima.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OneToOneServiceImpl implements OneToOneService {
    @Override
    public List<Card> selectAll() {
        List<Card> cardList = null;
        try (SqlSession sqlSession = MyBatisUtils.getSession()) {
            final OneToOneMapper mapper = sqlSession.getMapper(OneToOneMapper.class);
            cardList = mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cardList;
    }
}
