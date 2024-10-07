##
`@Bean` 是 Spring 框架中的一個註解，用於將方法標註為一個 Spring bean 的生成工廠方法。這意味著當 Spring 容器啟動時，這個方法會被調用，並返回一個對象，該對象將被註冊為 Spring 應用上下文中的一個 bean。

### 用法

- 通常在 `@Configuration` 註解的類中使用，這表示該類包含一個或多個 bean 定義的方法。
- 使用 `@Bean` 註解的方法會被 Spring 容器管理，並且返回的對象將被自動注入到需要它的其他 Spring bean 中。

### 示例

以下是一個簡單的示例，演示如何使用 `@Bean` 註解來創建 Spring bean：

```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyService myService() {
        return new MyService();
    }

    @Bean
    public MyRepository myRepository() {
        return new MyRepository();
    }
}
```

在這個例子中：

- `AppConfig` 類被註解為 `@Configuration`，表明它是一個配置類。
- `myService()` 和 `myRepository()` 方法被註解為 `@Bean`，意味著它們返回的對象（`MyService` 和 `MyRepository`）將被 Spring 管理。

### 主要特性

1. **範圍**：可以通過 `@Scope` 註解來控制 bean 的作用範圍，例如單例（singleton）或原型（prototype）。
  
2. **初始化和銷毀**：可以使用 `@PostConstruct` 和 `@PreDestroy` 註解來定義 bean 的初始化和銷毀邏輯。

3. **依賴注入**：使用 `@Autowired` 或構造函數注入等方式，Spring 可以自動解析和注入 bean 之間的依賴關係。

### 例子

假設我們有以下的 `MyService` 和 `MyRepository` 類：

```java
public class MyService {
    private final MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    // 服務邏輯
}

public class MyRepository {
    // 數據訪問邏輯
}
```

在 `AppConfig` 類中定義的 bean 將自動進行依賴注入，這樣當 `MyService` 被創建時，`MyRepository` 將會被自動注入到 `MyService` 的構造函數中。

### 總結

`@Bean` 是一個強大的註解，讓開發者能夠靈活地定義和管理 Spring bean。通過這個註解，Spring 能夠自動處理 bean 的生命週期和依賴關係，從而簡化了應用程序的配置和管理。