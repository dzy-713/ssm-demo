package com.rl.mes.pojo;


 /**
 * api通用返回对象
 *
 */
public class ApiResVo {

    //状态
    private String state;

    //消息
    private String msg;

    //返回对象
    private Object resBody;

    public ApiResVo(){

    }

    public ApiResVo(String state, String msg, Object obj){
        this.state=state;
        this.msg=msg;
        this.resBody=obj;
    }

    /**
     * 成功(含参)
     * @param obj
     * @return
     */
    public static ApiResVo success(Object obj){
        ApiResVo ApiResVo = new ApiResVo("1","ok",obj);
        return ApiResVo;
    }

    /**
     * 成功(不含参)
     * @return
     */
    public static ApiResVo success(){
        ApiResVo ApiResVo = new ApiResVo("1","ok",null);
        return ApiResVo;
    }

    /**
     * 失败
     * @param msg 错误信息
     * @return
     */
    public static ApiResVo error(String msg){
        ApiResVo ApiResVo = new ApiResVo("-1",msg,null);
        return ApiResVo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResBody() {
        return resBody;
    }

    public void setResBody(Object resBody) {
        this.resBody = resBody;
    }
}
