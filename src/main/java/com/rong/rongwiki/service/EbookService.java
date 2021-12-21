package com.rong.rongwiki.service;

import com.rong.rongwiki.domain.Ebook;
import com.rong.rongwiki.domain.EbookExample;
import com.rong.rongwiki.mapper.EbookMapper;
import com.rong.rongwiki.req.EbookReq;
import com.rong.rongwiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp resp = new EbookResp();
            BeanUtils.copyProperties(ebook, resp);
            respList.add(resp);
        }
        return respList;
    }
}
