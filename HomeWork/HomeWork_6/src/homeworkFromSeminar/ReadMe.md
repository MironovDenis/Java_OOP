* В классе User нарушен принцип единой ответственности. Содержатся методы save и report.
* В методе save() класса User нарушен принцип инверсии зависимостей.

1 Создал класс Persister, перенес в него метод save
2 Создал класс Reporter, перенес в него метод report
3 В Main реализовал вызов методов report и save для создаваемого пользователя