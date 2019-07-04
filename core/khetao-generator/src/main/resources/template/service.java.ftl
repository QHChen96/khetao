package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};

/**
 * <p>
    * ${table.comment!} 服务类
    * </p>
 *
 * @author ${author}
 * @email ${cfg.email}
 * @since ${date}
 * @version ${cfg.version}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

}
</#if>
