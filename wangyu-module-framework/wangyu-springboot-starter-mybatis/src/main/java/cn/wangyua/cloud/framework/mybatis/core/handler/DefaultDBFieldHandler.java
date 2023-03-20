package cn.wangyua.cloud.framework.mybatis.core.handler;

import cn.wangyua.cloud.framework.mybatis.core.dataobject.BaseDO;
import cn.wangyua.cloud.framework.web.core.util.WebFrameworkUtils;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DefaultDBFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (Objects.nonNull(metaObject)&&metaObject.getOriginalObject() instanceof BaseDO){
           BaseDO baseDO = (BaseDO)metaObject.getOriginalObject();
          LocalDateTime localDateTime =  LocalDateTime.now();
          //如果创建时间为空，则以当前时间为插入时间
          if(Objects.isNull(baseDO.getCreatTime())){
              baseDO.setCreatTime(localDateTime);
          }// 更新时间为空，则以当前时间为更新时间
          if (Objects.isNull(baseDO.getUpdateTime())){
              baseDO.setUpdateTime(localDateTime);
            }
          //web 模块的方法，找到当前登录用户的ID
            Long userId = WebFrameworkUtils.getLoginUserId();

        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
