**Опис Алгоритму**
<br>
<br>
RSA (Rivest-Shamir-Adleman) - це асиметричний алгоритм шифрування, який широко використовується
в сучасній криптології. Він був уперше запропонований Рономо Рівесті, Аді Шаміром та Леонардом
Адлеманом у 1977 році.
<br>
<br>
Загальний опис роботи алгоритму:
 - Генерація ключа:
   * Обираються 2 різних простих числа p та q
   * Обраховується їх добуток, n = p * q. Цю величину будемо називати модулем
   * Обраховується коефіцієнт Ейлера φ(n) = (p - 1) * (q - 1)
   * Обирається ціле число e (1 < e < φ(n)), яке є взаємно простим до φ(n). Це значення буде відкритим показником
   * Обчислити модульну мультиплікативну обернену d від e за модулем φ(n). Іншими словами, знайти d так, щоб (d * e) mod φ(n) = 1. Це значення є приватним показником.
 - Шифрування:
   * Щоб зашифрувати повідомлення M, відправник використовує відкритий ключ одержувача (e, n)
   * Повідомлення M перетворюється на ціле число m таке, що 0 ≤ m < n
   * Обчислюється зашифрований текст c = m^e mod n
 - Розшифровування:
   * Щоб розшифрувати зашифрований текст c, одержувач використовує свій закритий ключ (d, n)
   * Обчислюється текстове повідомлення m = c^d mod n
   
Безпека RSA базується на труднощах розкладання великих складених чисел на їхні прості множники. Для зламу шифрування RSA потрібно знайти прості множники модуля, що обчислювально дорого для великих чисел із достатньо довгими простими множниками.

Варто зазначити, що RSA в основному використовується для шифрування невеликих обсягів даних (наприклад, симетричних ключів шифрування) через його відносно повільну швидкість порівняно з алгоритмами симетричного шифрування. На практиці RSA часто використовується в поєднанні з симетричним шифруванням для безпечного зв’язку.


