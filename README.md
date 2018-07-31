#data-push-platform
## 系统运行环境
    jdk1.8 + 
    mysql5.6 +
    maven 3.3.3 +
    
## 启动说明
    启动模块: dpp-master
    启动类: com.guojin.dpp.master.DppMasterApplication
    系统配置文件: dpp-master/src/main/resources/application.properties
                本地运行调整mysql环境信息
    默认启动端口: 8080
    sql脚本: documents/sql 目录下
    
    *一键启动*
    dpp-master/run 目录下已经打好可运行包,不用编译代码即可运行,
    config目录是运行配置文件,调整参数后
    执行命令 java -jar data-push-platform.jar
## 接口文档
   启动工程之后，访问 
   http://127.0.0.1:8080/swagger-ui.html
## 模块说明
    documents   系统文档
    dpp-master 系统启动模块
    dpp-web 数据推送平台的web页面
    dpp-server 数据推送平台的服务端
    dpp-reciever   数据推送平台进行数据推送的接收者（桩程序）
    dpp-common   公共类


    

