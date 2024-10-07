##
`@JsonProperty` 是 Jackson 庫中的一個註解，用於在 Java 中進行 JSON 數據的序列化（將 Java 對象轉換為 JSON）和反序列化（將 JSON 轉換為 Java 對象）時，指定屬性與 JSON 鍵之間的映射關係。

### 用法

1. **對屬性進行標註**：可以將 `@JsonProperty` 註解應用於 Java 類的字段或 getter 方法，以指定該字段在 JSON 中的名稱。

2. **控制序列化和反序列化**：可以使用它來控制某些屬性在序列化或反序列化過程中的行為，例如設置是否必須存在或是否應該被忽略。

### 示例

```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    
    @JsonProperty("user_id")  // JSON 中的鍵名為 "user_id"
    private int id;

    @JsonProperty("user_name")  // JSON 中的鍵名為 "user_name"
    private String name;

    // Getter 和 Setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

### 主要特性

- **自定義鍵名**：通過 `@JsonProperty("custom_key_name")` 可以自定義 JSON 中的鍵名。
- **必須屬性**：可以指定某個屬性在反序列化時是否必須存在。
- **忽略屬性**：如果想要在序列化/反序列化中忽略某個屬性，可以使用 `@JsonIgnore` 註解。

### 例子

假設有以下 JSON 數據：

```json
{
    "user_id": 1,
    "user_name": "Alice"
}
```

使用上述的 `User` 類進行反序列化時，`id` 將被設置為 `1`，`name` 將被設置為 `"Alice"`。

### 總結

`@JsonProperty` 是一個非常有用的工具，能夠幫助開發者在處理 JSON 數據時，清晰地定義 Java 對象的屬性與 JSON 鍵之間的映射關係，從而提高代碼的可讀性和可維護性。