package cn.wangyua.cloud.framkework.common.Excepiton;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 逻辑异常 ServiceException
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException{
    /**
     * 业务错误码
     *
     * @see ServiceErrorCodeRange
     */
    private Integer code;
    /**
     * 错误提示
     */

    private String msg;
    /**
     * 空构造方法，避免反序列化问题
     */

    public ServiceException(){
    }
    public ServiceException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
    public ServiceException(Integer code ,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode(Integer code){ return  code;}

    public ServiceException setCode(Integer code){
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return msg;
    }


    public ServiceException setMsg(String msg){
        this.msg = msg;
        return this;
    }
}
