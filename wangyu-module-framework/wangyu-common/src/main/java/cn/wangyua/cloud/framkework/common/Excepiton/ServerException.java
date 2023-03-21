package cn.wangyua.cloud.framkework.common.Excepiton;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
/**
 * 服务器异常 ServerException
 */
public class ServerException extends RuntimeException{
    /**
     * 全局错误码
     *
     * @see GlobalErrorCodeConstants
     */
    private Integer code;
    /**
     * 错误提示
     */
    private String msg;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ServerException(){}

    public ServerException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }
    public ServerException(Integer code, String msg){
        this.code =code;
        this.msg = msg;
    }

    public Integer getCode(){return code ;}

    public ServerException setCode(Integer code){
        this.code = code;
        return this;
    }


    @Override
    public String getMessage() {
        return msg;
    }

    public ServerException setMsg(String msg){
        this.msg = msg ;
        return this;
    }
}
