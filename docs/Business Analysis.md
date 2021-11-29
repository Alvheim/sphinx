# Bussiness Objects

## Component-Object: KC-Student

### Attributes

| Назва атрибуту (Attribute name) | Опис атрибуту (Attribute Description) |
| :-----------------------------: | :------------------------------------:|
| Student ID | Унікальний ідентифікатор студента в системі. |
| First Name | Ім’я студента. |
| Middle Name | По-батькові студента. |
| Last Name | Прізвище студента. |
| Username | Псевдонім студента. |
| Birthday | Дата народження. |
| Email | Електронна адреса студента. |
| Mobile Number | Номер телефону студента. |
| CommunicationChannels | Як можна зв'язатися з студентом: {channel: channel_value; channel: channel_value}. |

Channel: Additional Mobile Number, Facebook, Telegram, Instagram, Twitter, Discord...

### Operations

1. Сreate KC-Student. <br>
2. Read KC-Student. <br>
3. Update KC-Student. <br>
4. Delete KC-Student. <br>

## Component-Object: KC-Educator

### Attributes

| Назва атрибуту (Attribute name) | Опис атрибуту (Attribute Description) |
| :-----------------------------: | :------------------------------------:|
| Educator ID | Унікальний ідентифікатор викладача. |
| First Name | Ім’я викладача. |
| Middle Name | По-батькові викладача. |
| Last Name | Прізвище викладача. |
| Type | Тип викладача: лектор, практик, ментор. |
| Birthday | Дата народження. |
| Email | Електронна адреса викладача. |
| Mobile Number | Номер телефону викладача. |
| CommunicationChannels | Як можна зв'язатися з викладачем: {channel: channel_value; channel: channel_value}. |

Channel: Additional Mobile Number, Facebook, Telegram, Instagram, Twitter, Discord...

### Operations

1. Сreate KC-Educator. <br>
2. Read KC-Educator. <br>
3. Update KC-Educator. <br>
4. Delete KC-Educator. <br>

## Component-Object: KC-Resource

### Attributes

| Назва атрибуту (Attribute name) | Опис атрибуту (Attribute Description) |
| :-----------------------------: | :------------------------------------:|
| SourceID | Унікальний ідентифікатор джерела. |
| Branch | Множина споріднених джерел. |
| Title | Назва джерела. |
| Description | Зміст/Структура джерела. |
| Form | Форма джерела. |
| Work Mode | Рекомендований спосіб опрацювання джерела. |
| Scope of Work (Measure) | Одиниця виміру. |
| Scope of Work (Value) | Значення одиниці виміру. |
| Comments | Коментарі того, хто додав джерело. |

Form: "Книга", "Аудіокнига", "Відео"...

Work Mode: "Partially", "Full-consistently", "Full-inconsistently".

### Operations

1. Сreate KC-Resource. <br>
2. Read KC-Resource. <br>
3. Update KC-Resource. <br>
4. Delete KC-Resource. <br>
 
## Component-Object: KC-Task

### Attributes

| Назва атрибуту (Attribute name) | Опис атрибуту (Attribute Description) |
| :-----------------------------: | :------------------------------------:|
| Task ID | Унікальний ідентифікатор завдання. |
| Title | Заголовок завдання. |
| Description | Опис завдання. |
| Start Date | Дата початку виконання завдання. |
| Deadline | Очікуваний термін здачі завдання.|
| Finish Date | Кінець терміну здачі завдання.|
| Priority | Пріоритет завдання.|
| Status | Статус завдання: {planned; started; missed; finished.} |

### Operations

1. Сreate KC-Resource. <br>
2. Read KC-Resource. <br>
3. Update KC-Resource. <br>
4. Delete KC-Resource. <br>

## Component-Object: KC-CourseParticipation

### Attributes

| Назва атрибуту (Attribute name) | Опис атрибуту (Attribute Description) |
| :-----------------------------: | :------------------------------------:|
| Course ID | Унікальний ідентифікатор курсу. |
| Student ID | Унікальний ідентифікатор ресурсу. |

### Operations

1. Check if Student in Course. <br>
2. Get all Student's for Course. <br>
3. Get all Course's for Student. <br>
4. Add Student to Course. <br>
5. Remove Student for Course. <br>
6. Remove Course for Student's. <br>

## Component-Object: KC-Course
???

# Security Access Rules

"[Student]:= primitive
[Educator]:= primitive
[Resource]:= primitive
[Task]:= primitive
"[Сourse]:= [Student]'s + [Educator] + [Resource]'s + [Task]'s"
[Classroom]:= [Student]'s + [Educator]
[Task] => [Reward] => {Achievement; Role} 
[Role] => [RoleSystem]

[Resources in Progress]
[Classroom]
[Achievement]
[Notification]
[NotificationInbox]
[ChannelOptions]
[MessagePattern]
[Role?]
[RoleSystem?]
[RoleSystems?]
[Reward?]
[Group?]
[Participation in Group?]
[Event?]
[Involvement in Event]
