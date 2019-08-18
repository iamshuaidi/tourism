/*
package com.tourism.controller;

public class CodeController {


    */
/**
     * 发送短信验证码
     *
     * @param json 前台传入电话号码
     * @return 返回发送结果向前台
     *//*

    @RequestMapping("/getTestCode")
    @ResponseBody
    public GetTestCodeResult sendCode(@RequestParam(value = "phone", defaultValue = "") String phoneNumber) {

        GetTestCodeResult result = new GetTestCodeResult();
        if (phoneNumber == null || phoneNumber.length() == 0) {
            result.setState(Result.ERROR);
            result.setMessage("手机号为空");
            return result;
        }
        String code = TestCode.getCode();
        if (code == null || code.length() == 0) {
            result.setState(Result.ERROR);
            result.setMessage("无效的验证码");
            return result;
        }

        try {
            SMS.batchsendsm(phoneNumber, code);
        } catch (Exception e) {
            result.setState(Result.ERROR);
            result.setMessage("验证码发送失败");
            return result;
        }
        TestCodeInforVo testCodeInfor = new TestCodeInforVo();
        testCodeInfor.setCode(code);
        testCodeInfor.setPhone(phoneNumber);
        testCodeInfor.setDate(System.currentTimeMillis());
        testCodeInforMap.put(phoneNumber, testCodeInfor);
        result.setState(Result.SUCCESS);
        result.setMessage("验证码发送成功");
        result.setData(code);                    //测试
        return result;
    }
}*/
