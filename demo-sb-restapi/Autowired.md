`@Autowired` 是 Spring 框架中的一個註解，用於自動注入依賴。這意味著，當 Spring 容器創建一個 bean 時，`@Autowired` 註解可以告訴 Spring 自動解析和注入該 bean 所需的其他依賴項。這樣可以簡化依賴管理，減少手動配置。

### 用法

- `@Autowired` 可以應用於構造函數、方法或字段。
- Spring 在應用上下文中查找匹配的 bean，並自動將其注入到被註解的屬性或方法中。

### 示例

以下是一個使用 `@Autowired` 的簡單示例：

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    private final MyRepository myRepository;

    // 使用構造函數進行依賴注入
    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void performService() {
        // 使用 myRepository 進行服務邏輯
    }
}

@Component
public class MyRepository {
    // 數據訪問邏輯
}
```

在這個例子中：

- `MyService` 類使用 `@Autowired` 註解標註其構造函數，告訴 Spring 自動注入 `MyRepository` 的實例。
- `MyRepository` 類也使用 `@Component` 註解，以便 Spring 將其識別為一個可管理的 bean。

### 主要特性

1. **自動裝配模式**：`@Autowired` 可以與不同的自動裝配模式結合使用：
   - **按類型自動裝配**：Spring 會查找與屬性類型匹配的 bean。
   - **按名稱自動裝配**：如果有多個類型匹配的 bean，Spring 會根據屬性名進行匹配。

2. **可選依賴**：使用 `required` 屬性可以指定某個依賴是否是必需的：
   ```java
   @Autowired(required = false)
   private OptionalDependency optionalDependency;
   ```

3. **Setter 方法注入**：`@Autowired` 也可以用於 setter 方法，這樣可以更靈活地進行依賴注入：
   ```java
   @Autowired
   public void setMyRepository(MyRepository myRepository) {
       this.myRepository = myRepository;
   }
   ```

4. **字段注入**：可以直接在字段上使用 `@Autowired`，但這種方式不推薦，因為它不利於測試和可維護性：
   ```java
   @Autowired
   private MyRepository myRepository;
   ```

### 總結

`@Autowired` 是 Spring 中用於自動注入依賴的重要註解。它使開發者能夠專注於業務邏輯，而無需手動管理和配置依賴關係。通過使用 `@Autowired`，開發者可以簡化代碼結構，提高可讀性和可維護性。