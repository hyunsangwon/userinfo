import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {

	val kotlinVersion = "1.3.31"
	val springBootVersion ="2.1.4.RELEASE"

	id("java")
	kotlin("jvm") version kotlinVersion
	kotlin("kapt") version kotlinVersion

	/* kotlin-allopen : kotlin class는 기본적으로 Final
	*  Entity class는 Final로 선언되어 있으면 안된다.
	*  allopen plug-in을 통해 final -> open 형태로 선언해주자.
	* */
	id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
	/* kotlin-noarg :
	* 주석이달린 Class에 인수가 없는 생성자 자동생성
	* */
	id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
	id("org.springframework.boot") version springBootVersion
	/*dependency-management : 의존성 관리
	* */
	id("io.spring.dependency-management") version "1.0.7.RELEASE"
	application
}

group = "io.sangwon"
version = "0.0.1-SNAPSHOT"


java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

application{
	applicationName = "board"
	group = "io.sangwon"
	mainClassName = "io.sangwon.board.BoardApplicationKt" // web.xml
}

repositories {
	jcenter()
	mavenCentral()
}

dependencies {

	val graphqlJavaToolsSpringVersion = "5.8.1"
	val graphqlJavaToolsVersion = "5.6.0"
	/*graphql-spring-boot-starter: GraphQL 서버를 매우 짧은 시간에 실행 가능하게 만드는 쉬운 방법을 제공
	* graphql-java-tools: 동적 해석기 배선을 쉽게하기 위해 graphql-java-tools도 사용해야합니다.?!
	* graphiql-spring-boot-starter : GraphQL UI 인터페이스 제공 (응용 프로그램에서 사용하려면 추가)
	* */
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:$graphqlJavaToolsSpringVersion")
	implementation("com.graphql-java-kickstart:graphql-java-tools:$graphqlJavaToolsVersion")
	implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:$graphqlJavaToolsVersion")
	implementation("com.graphql-java-kickstart:graphql-java-servlet:7.4.1")
	/*spring security*/
	implementation("org.springframework.boot:spring-boot-starter-security")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	/* thymeleaf-layout-dialect: html header&footer */
	implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.3.0")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
