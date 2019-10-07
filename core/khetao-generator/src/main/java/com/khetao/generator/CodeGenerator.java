package com.khetao.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author chenqinhao
 * @version 1.0
 * @email qhchen96@gmail.com
 * @since 2019-06-15
 */
public class CodeGenerator {

    private GeneratorConfigBean configBean;

    public CodeGenerator(GeneratorConfigBean configBean) {
        this.configBean = configBean;
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public String[] scanners(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());

        if (scanner.hasNext()) {
            String ipt = scanner.nextLine();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt.split(" ");
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public void gen() {
        final String basePath = System.getProperty("user.dir") +configBean.getBaseUrl();
        AutoGenerator generator = new AutoGenerator();
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(basePath + "/src/main/java");
        globalConfig.setAuthor(configBean.getAuthor());
        globalConfig.setOpen(false);
        globalConfig.setFileOverride(false);
        globalConfig.setSwagger2(false);
        globalConfig.setFileOverride(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setBaseResultMap(true);
        globalConfig.setDateType(DateType.TIME_PACK);
        globalConfig.setIdType(IdType.AUTO);
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.khetao.serve");
        generator.setPackageInfo(pc);


        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(configBean.getDburl());
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername(configBean.getDbuser());
        dataSourceConfig.setPassword(configBean.getDbpwd());
        dataSourceConfig.setTypeConvert(new MyConvert());


        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("version", configBean.getVersion());
                map.put("email", configBean.getEmail());
                this.setMap(map);
            }
        };

        List<FileOutConfig> fileList = new ArrayList<>();

        String res = "";

        fileList.add(new FileOutConfig(res + "/template/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return basePath + "/src/main/resources/mapper/" + pc.getModuleName() + "/"  + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(fileList);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(res + "/template/entity.java")
                .setService(res + "/template/service.java")
                .setServiceImpl(res + "/template/serviceImpl.java")
                .setMapper(res + "/template/mapper.java")
                .setXml(null)
                .setController("/template/controller.java");
        generator.setTemplate(templateConfig);
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSkipView(true);
        strategy.setCapitalMode(false);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);


        strategy.setSuperEntityClass("com.khetao.base.entity.BaseEntity");
        strategy.setSuperServiceClass("com.khetao.base.service.BaseService");
        strategy.setSuperServiceImplClass("com.khetao.base.service.BaseServiceImpl");
        strategy.setSuperControllerClass("com.khetao.base.BaseController");


        strategy.setInclude(scanners("表名"));
        strategy.setTablePrefix(scanners("前缀"));


        generator.setGlobalConfig(globalConfig);


        generator.setTemplateEngine(new MyFreemarkerTemplateEngine(basePath + "/src/main/resources/"));
        generator.setCfg(injectionConfig);
        generator.setDataSource(dataSourceConfig);
        generator.setStrategy(strategy);

        generator.execute();
    }

}
