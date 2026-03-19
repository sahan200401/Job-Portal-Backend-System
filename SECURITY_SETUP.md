# Job Portal Backend - Security Improvements Setup

## Required Dependencies

Add the BCrypt dependency to your project:

### Maven (pom.xml)
```xml
<dependency>
    <groupId>org.mindrot</groupId>
    <artifactId>jbcrypt</artifactId>
    <version>0.4</version>
</dependency>
```

### Gradle (build.gradle)
```gradle
implementation 'org.mindrot:jbcrypt:0.4'
```

## Configuration Setup

1. **Update config.properties** in `src/config.properties`:
   - Set your actual database password
   - Adjust BCrypt rounds if needed (default: 12)

2. **Environment Variables (Optional)**:
   - `DB_URL`: Database connection URL
   - `DB_USERNAME`: Database username  
   - `DB_PASSWORD`: Database password
   - `BCRYPT_ROUNDS`: Password hashing rounds

## Security Features Implemented

### 1. Password Hashing
- All passwords are now hashed using BCrypt
- Automatic hashing on user registration
- Secure password verification on login

### 2. Configuration Management
- Database credentials moved to config file
- Environment variable fallback support
- No hardcoded sensitive information

### 3. Database Security
- Prepared statements prevent SQL injection
- Secure password storage in database

## Migration Notes

**Important**: Existing plain text passwords in the database will need to be migrated. Users will need to reset their passwords after this update.

## Usage Examples

### User Registration (Password auto-hashed)
```java
User user = new User("john_doe", "plainPassword123", "john@example.com", User.Role.CANDIDATE);
// Password is automatically hashed
```

### User Login (Secure verification)
```java
User user = userDAO.findByUsernameAndPassword("john_doe", "plainPassword123");
// Password verification uses BCrypt
```

### Configuration Access
```java
String dbUrl = ConfigUtil.getDbUrl();
String dbPassword = ConfigUtil.getDbPassword();
```
