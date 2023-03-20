package cn.wangyua.cloud.framkework.common.Excepiton;

import lombok.Data;

@Data
public class ErrorCode {

    private Integer code;

    private String msg;

    public ErrorCode(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
