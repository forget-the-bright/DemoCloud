package com.mr.wh.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor//生成全参构造器
@NoArgsConstructor//生成无参构造器
@Data//以下注解的集合@ToString @EqualsAndHashCode @Getter @Setter @RequiredArgsConstructor

//@ToString 作用于类，覆盖默认的toString()方法，可以通过of属性限定显示某些字段，通过exclude属性排除某些字段。
//@EqualsAndHashCode 作用于类，覆盖默认的equals和hashCode

//@Getter @Setter  作用类上，生成所有成员变量的getter/setter方法；
//作用于成员变量上，生成该成员变量的getter/setter方法。可以设定访问权限及是否懒加载等。

//@RequiredArgsConstructor 生成包含final和@NonNull注解的成员变量的构造器；
//@NonNull 主要作用于成员变量和参数中，标识不能为空，否则抛出空指针异常。
public class Payment implements Serializable {
private Long id;
private String serial;
}
