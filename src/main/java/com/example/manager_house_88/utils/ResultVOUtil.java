package com.example.manager_house_88.utils;


import com.example.manager_house_88.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultVOUtil {

    private static ResultVO resultVO = ResultVO.getResultVO();

    public static ResultVO success(Object object) {
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(String msg){
        resultVO.setCode(1);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
