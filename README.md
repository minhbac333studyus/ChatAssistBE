# 🤖 ChatAssistBE – Ứng dụng Chat hỗ trợ AI

Đây là hệ thống backend cho một ứng dụng trò chuyện có tích hợp AI, sử dụng Spring Boot kết hợp với cơ sở dữ liệu PostgreSQL. Ứng dụng cho phép người dùng tạo cuộc hội thoại, gửi và nhận tin nhắn từ bot (hoặc hệ thống).

---

## 🧩 Thiết kế CSDL & Mối quan hệ giữa các bảng

### Các thực thể chính trong hệ thống:

---

### 🧑‍💼 `UserEntity` – Người dùng

- Mỗi người dùng có:
    - `id`: định danh tự tăng
    - `username`: tên tài khoản (duy nhất)
    - `password`: mật khẩu
- Một người dùng có thể tạo nhiều **cuộc trò chuyện** (`ConversationEntity`)

---

### 🗣️ `ConversationEntity` – Cuộc hội thoại

- Trường:
    - `id`: định danh
    - `user`: người tạo cuộc hội thoại (Many-to-One với `UserEntity`)
- Mỗi cuộc hội thoại chứa nhiều tin nhắn (`MessageEntity`)

---

### 💬 `MessageEntity` – Tin nhắn

- Trường:
    - `id`: định danh
    - `conversation`: cuộc hội thoại chứa tin nhắn (Many-to-One)
    - `content`: nội dung tin nhắn
    - `role`: loại người gửi (USER, SYSTEM, ASSISTANT)
- Các tin nhắn được phân loại theo vai trò `Role` (Enum)

---

### 🔐 `Role` – Kiểu người gửi (Enum)

- `USER`: người dùng
- `ASSISTANT`: trợ lý AI
- `SYSTEM`: hệ thống

---

### 🔁 Mối quan hệ giữa các bảng (ERD)

```plaintext
UserEntity (1) ────< (n) ConversationEntity (1) ────< (n) MessageEntity

```

## ⚙️ Hướng dẫn Setup Dự Án (Sử dụng PostgreSQL)

Để chạy được hệ thống backend của ChatAssistBE, bạn cần thực hiện các bước sau:

---

### 1. 🛠️ Cài đặt PostgreSQL & tạo cơ sở dữ liệu

- Cài đặt PostgreSQL từ [https://www.postgresql.org/download/](https://www.postgresql.org/download/)
- Sau khi cài xong, đăng nhập bằng công cụ `psql` hoặc dùng phần mềm như pgAdmin.
- Tạo một database với lệnh:

```sql
CREATE DATABASE chat_assist;
```
### 2. Cấu hình kết nối trong application.properties

Tại thư mục src/main/resources, mở hoặc tạo file application.properties và thêm nội dung sau:

# Cấu hình kết nối DB
``` 
spring.datasource.url=jdbc:postgresql://localhost:5432/chat_assist
spring.datasource.username=postgres
spring.datasource.password=your_password
```


# Hibernate + JPA
```
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

📌 Ghi chú:
```
ddl-auto=update: tự động cập nhật bảng theo entity (chỉ dùng khi dev)

show-sql=true: hiển thị câu lệnh SQL trong terminal/log
```
3. Build và chạy ứng dụng
✅ Sử dụng Maven wrapper (không cần cài Maven toàn cục):
```
./mvnw clean install
./mvnw spring-boot:run
```

✅ Hoặc chạy trong IDE như IntelliJ:

Mở file ChatAssistBeApplication.java

Bấm chuột phải → Run

📡 API hiện tại
```
GET /chat/{cid}?content=... → Gửi câu hỏi đến bot theo Conversation ID

GET /test/messages → Lấy danh sách tin nhắn mẫu

GET /test → Kiểm tra kết nối đơn giản
```
🚀 Định hướng mở rộng
```
Tích hợp AI thực tế (OpenAI API, LangChain, v.v.)

Quản lý người dùng nâng cao (JWT, OAuth2)

Giao diện chat realtime qua WebSocket hoặc SSE

Docker hóa hệ thống để triển khai dễ dàng
```
📬 Liên hệ & Đóng góp

Nếu bạn muốn đóng góp, tạo issue hoặc hỗ trợ phát triển dự án:
