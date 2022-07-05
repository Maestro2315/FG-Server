# FightGame
## Необходимо разработать консольную текстовую игру-дуэль.

**Цель игры** - победить противника (компьютер) путем последовательного применения оружия или защиты.

Игра может быть на любую эпоху (бой рыцарей, лучная перестрелка, бой гладиаторов, перестрелка танков, перестрелка современных солдат, космодесантников и т.п. - кого угодно. Воевать друг с другом могут персонажи как одного класса, так и разных (танк против БТР, мечник против чела с топором и т.п.)

Главное придерживаться примерно одной эпохи, иначе сложно будет реализовать. :wink:

Необходимо заранее создать вручную файлы конфигурации некоторого набора предметов. Для начала достаточно сделать 6 предметов атаки и 6 предметов защиты.
У каждого предмета должны быть как минимум следующие характеристики:
- название
- очки защиты (от 1 до 5)
- очки урона (от 1 до 5)

При запуске игра должна автоматически прочитать эти файлы и проинициализировать соответствующие объекты предметов, чтобы потом с ними можно было работать.

В самом начале нужно выбрать два предмета защиты и два предмета атаки для своего персонажа (считаем, что слотов предметов у нас только два). Нельзя выбрать два одинаковых предмета.
Для игрока компьютера предметы подбираются случайным образом из тех, что остались после выбора предметов игроком-человеком (такая вот дискриминация железных ублюдков)
Конфигурации игрока и компьютера нужно сохранить в файлы и при следующем открытии игры читать оттуда. Если программа запускается в первый раз и файлы игроков не найдены, то предложить пользователю перейти к выбору предметов.

*Изначально игрокам присваивается по 100 hp*

Также необходимо создать и сохранить в файлы описания персонажей. Надо сделать минимум 4 разных персонажа (например, лучник, мечник, копейщик и чел с топором)
У всех персонажей должны быть следующие характеристики:
- навык атаки - вещественное число от 0 до 1. Это показывает, насколько реализуется дамаг выбранного предмета атаки. Например, вы выбрали меч с уроном 3, при этом у вашего персонажа навык атаки 0.5. Это значит, что с помощью меча этот персонаж может нанести не более 1.5 единицы урона (урон * навык атаки, т.е. 3 * 0.5 = 1.5)
- навык защиты - аналогично навыку атаки, тоже число от 0 до 1.
Пока считаем, что навыки атаки и защиты в ходе игры не меняются (персонажи - тупые тапки, которые не умеют прокачиваться). Сколько изначально задано - столько и есть. Но в дальнейшем возможно будем это дописывать.

**Как происходит сам бой:**

✅1. В свой ход выбираем из меню то, что хотим сделать:
- использовать защиту (с выбором вида защиты, если их в наличии несколько)
- использовать атаку (с выбором оружия, если их несколько)

✅2. Когда ход переходит к компьютеру, он случайным образом выбирает защиту или атаку и соответственно предмет (пока не будем писать ему хитрый интеллект, пусть рандомит)

✅3. Когда человек и комп выбрали свои предметы и действия, происходит подсчет урона от обмена действиями. Как и в любой битве, тут должен быть элемент рандома, удачи - это тоже некое случайное число от 0 до 1, которое показывает, насколько удалось реализовать атаку или защиту (вдруг, взмахнув топором, этот придурок поскользнулся и упал - тогда дамага он нанесет 0).


**Пример:**
У игрока-человека выбран предмет "топор" с уроном 5 и защитой 4, у самого игрока навык атаки 0.8, навык защиты 0.4. Выбрано действие "атака". Успех атаки нарандомился как 0.5. Итого получаем, что за свой ход этот персонаж может нанести противнику максимальный урон, равный 5 * 0.8 * 0.5 = 2. 
У игрока-компьютера выбран предмет "меч" с уроном 3 и защитой 3, у самого игрока навык защиты 0.9. Выбрано действие "защита". Успех защиты нарандомился как 0.6. Итого получаем, что за свой ход этот персонаж может отразить максимальное кол-во единиц атаки, равное 3 * 0.9 * 0.6 = 1.62

~~Т.к. атаку применял только человек, а комп только защищался, то у человека hp не изменится, а у компа уменьшится на число, равное 2 - 1.62 = 0.38
Итого после первого хода у человека останется 100 hp, а у компа 100 - 0.38 = 99.62 hp~~

👻 Обратить внимание, что если оба выбрали действие "атака", то оба наносят друг другу какой-то урон (считается аналогично тому, как описано выше).
Если оба выбрали защиту, то по факту ничего не происходит. Очки урона будут у обоих по нулям, поэтому hp за этот ход не поменяется. Так и будут оба весь ход стоять, как дураки, подняв щит или прикрывшись топором или чем там еще.

✅4. После завершения подсчета очков и обновления hp (кстати, его надо не забыть записать персонажам в файлы), ход завершается и начинается новый ход.

Общие требования к программе:

**Пункты стартового меню игры:**
- просмотр всех типов персонажей (сначала просто списком имен, затем можно выбрать какой-то и показать детали)
- просмотр всех доступных предметов (сначала просто списком названий, затем можно выбрать какой-то и показать детали)
- выбор предметов атаки и защиты
- старт игры
- выход

**Пункты меню при очередном ходе:**
- выбор действия (атака/защита)
- выбор предмета
- в бой! (пересчитать очки и перейти к следующему ходу)
- прервать игру (в этом случае текущие hp игроков сохраняются, и игра переходит в стартовое меню)

:bell: P.S : Все public-методы должны быть снабжены JavaDoc
На все public-методы должны быть написаны unit-тесты (взаимодействие с пользователем путем ввода-вывода в консоль тестить не надо)
Должны быть реализованы все методы класса Object, которые требуют переопределения
Для проекта должен быть создан новый репозиторий в github
Сообщения к коммитам должны соответствовать тому, что реально было сделано, например, "player classes added", "items types implemented" и т.п.
Все основные действия должны быть залогированы в файл
Характеристики персонажей/предметов хранить в файлах json/yaml/xml - по вашему выбору. Но главное, чтобы у всех был один и тот же формат (чтобы не было такого, что игроки хранятся в xml, предметы в yaml и т.п. зоопарк)