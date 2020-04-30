项目简介：

   基于框架 Springboot + ElasticSearch+Tkmybatis+vue 实现博客网站检索系统  

 
项目资源依赖：

 ElasticSearch：elasticsearch-6.3.2 下载地址：https://www.elastic.co/cn/downloads/elasticsearch

 Logstash:  logstash-6.3.2（同步mysql数据库数据）下载地址：https://www.elastic.co/cn/downloads/logstash

 ik分词器：elasticsearch-analysis-ik-6.3.2（智能分词搜索）下载地址：https://github.com/medcl/elasticsearch-analysis-ik

maven依赖：

        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-web</artifactId>
            </dependency>
     
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <scope>runtime</scope>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <optional>true</optional>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
                <exclusions>
                    <exclusion>
                        <groupId>org.junit.vintage</groupId>
                        <artifactId>junit-vintage-engine</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>2.1.1</version>
            </dependency>
            <dependency>
                <groupId>tk.mybatis</groupId>
                <artifactId>mapper-spring-boot-starter</artifactId>
                <version>2.1.5</version>
            </dependency>
     
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
            </dependency>
        </dependencies>

数据库表：
    CREATE TABLE `t_blog` (
      `id` int(11) NOT NULL AUTO_INCREMENT,
      `title` varchar(255) DEFAULT NULL COMMENT '标题',
      `author` varchar(255) DEFAULT NULL COMMENT '作者',
      `content` mediumtext COMMENT '内容',
      `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
      `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
