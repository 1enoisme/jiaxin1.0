package cn.wangyua.cloud.framkework.common.pojo;

import cn.wangyua.cloud.framkework.common.Excepiton.ErrorCode;
import cn.wangyua.cloud.framkework.common.Excepiton.enums.GlobalErrorCodeConstants;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CommonResult<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    private Integer code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg() ()
     */
    private String msg;

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     *
     * 因为 A 方法返回的 CommonResult 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param result 传入的 result 对象
     * @param <T> 返回的泛型
     * @return 新的 CommonResult 对象
     */
    public static <T> CommonResult<T> error(CommonResult<?> result){ return error(result.code,result.msg);}

    public static <T> CommonResult<T> error(Integer code,String msg){
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code),"code 必须是错误的！");
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = code;
        commonResult.msg = msg;
        return commonResult;
    }
    public static <T> CommonResult<T> error(ErrorCode errorCode){
        return error(errorCode.getCode(),errorCode.getMsg());
    }
    public static <T> CommonResult<T> success(T data){
       CommonResult<T> commonResult = new CommonResult<>();
       commonResult.code = GlobalErrorCodeConstants.SUCCESS.getCode();
       commonResult.msg = "";
       commonResult.data = data;
       return commonResult;
    }

    public boolean isSuccess(Integer code){
        return Objects.equals(code,GlobalErrorCodeConstants.SUCCESS.getCode());
    }

}
