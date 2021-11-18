# TzIpApp


## Description
Получение ip с интернета,отображение истории запросов в сеть на получение ip

## Main Stack : Retrofit,Coroutines,LiveData,Mvvm,Dagger,View binding <br/>
SOLID,OOP,Clean architecture,JUnit tests<br/><br/>
Разбиение приложения на data, domain, presentation слои<br/>
Маппинг обЪектов через слои<br/><br/>
В качестве предоставления зависимостей(di) я использовал "Dagger2"<br/><br />
Для навигации приложения была использована библиотека "Navigation component"

### Tests

Необходимые классы покрыты юнит - тестами

<img 
src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/ip_tests_result.png?alt=media&token=94588144-b6d1-496c-ac1b-8df53fbf7712"/>

#### package core
 - [IpMapperTest](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/test/java/com/zinoview/tzipapp/core/IpMapperTest.kt)<br/>
 - [IpStateMapperTest](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/test/java/com/zinoview/tzipapp/core/IpStateMapperTest.kt)<br/>

#### package data
- [IpRepositoryTest](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/test/java/com/zinoview/tzipapp/data/IpRepositoryTest.kt)<br/>
- [ExceptionMapperTest](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/test/java/com/zinoview/tzipapp/data/ExceptionMapperTest.kt)<br/>
- [ResourceProviderTest](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/test/java/com/zinoview/tzipapp/data/ResourceProviderTest.kt)<br/>

### Разбиение приложение на фичи 

### Feature IA01 show my ip (данную фичу можно протестировать согласно тесткейсам)

[IA01TestCases](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/main/java/com/zinoview/tzipapp/testcases/IA01TestCases)<br/>

#### Progress state 

<img src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/photo_2021-11-18_21-24-47.jpg?alt=media&token=d8540cb7-0432-4e3f-9f9a-8f043df188c3" width="300" height="550"/>

Состояние ошибки,в данном случае я отключил интернет
#### Error state 

<img src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/photo_2021-11-18_21-24-49.jpg?alt=media&token=1fdeef1b-1e61-4985-aaf8-ebdf0ace43fd" width="300" height="550"/>

#### Success state
Успешное получение ip с сервера

<img src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/photo_2021-11-18_21-24-51.jpg?alt=media&token=bdffa96b-8372-4d6c-8eb3-73a2d708e614" width="300" height="550"/>

### Feature IA02 show history recent requests (данную фичу можно протестировать согласно тесткейсам)
[IA02TestCases](https://github.com/KostyaGig/TzIpApp/blob/master/app/src/main/java/com/zinoview/tzipapp/testcases/IA02TestCases)<br/>

Состояние Empty(когда не было сделаное ни одного запроса в сеть,но мы решили посмотреть список уже сделанныз запросов)<br/>
<img src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/photo_2021-11-18_21-24-52.jpg?alt=media&token=a8724ec5-0373-4953-b3fe-e3a164ed2795" width="300" height="550"/>

Состояние Success(отображение ip,полученного с сервера, а также отображение времени,затраченного на данный запрос в сеть)<br/>
<img src="https://firebasestorage.googleapis.com/v0/b/fir-mvvm-c45df.appspot.com/o/photo_2021-11-18_21-24-53.jpg?alt=media&token=9c3d64cf-e617-481b-8d5d-bcb42eab93cb" width="300" height="550"/>
