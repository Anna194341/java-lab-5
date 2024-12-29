UML-діаграма:
![image](https://github.com/user-attachments/assets/39172847-ccc2-4c24-a943-fe49517a228d)

1. Опис взаємодії між компонентами
FinancialEntry описує фінансові транзакції (доходи чи витрати).
FinancialGroup може містити декілька компонентів типу FinancialEntry або інші FinancialGroup.
FinancialVisitors виконують операції над компонентами (обчислення, створення звітів, конверсія валюти).
CurrencyConversionVisitor робить конвертацію валют на основі обмінних курсів.
ReportGenerationVisitor генерує текстові звіти.
TotalCalculationVisitor обчислює загальні суми для кожної валюти.

2. Пояснення застосування кожного шаблону
У роботі було використано Composite Pattern та Visitor Pattern. 
- Композит: FinancialEntry у структурї це листок, а FinancialGroup - контейнер. Розом вони є  FinancialComponent.
- Відвідувач: Дозволяє додавати нові операції до FinancialComponent без зміни їхньої структури.

3. Опис основних класів та їх відповідальності
FinancialEntry: Зберігає деталі транзакції, включаючи суму, тип, дату та опис.
FinancialGroup: Керує компонентами та обчислює їхню загальну суму.
CurrencyConversionVisitor: Конвертує суми у цільову валюту за заданими обмінними курсами.
ReportGenerationVisitor: Генерує текстові звіти про фінансові дані.
TotalCalculationVisitor: Рахує загальні суми для кожного типу валюти.
