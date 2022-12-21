# InditexExam

A Spring API that provides an endpoint for recovering a product given product id, brand id and a date. 

## Requirements

* Maven 3.8.6+
* JDK 17+

## Usage

```bash
bash mvnw spring-boot:run
```

## Example cURL

```
curl --location --request GET 'http://localhost:8080/api/prices/price?product=35455&brand=1&date=2020-06-14T16:00:00'
```

## Example JSON return

```
{
    "priceList": 2,
    "brandId": 1,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "productId": 35455,
    "price": 25.45,
    "curr": "EUR"
}
```

## Testing

To run the tests, in the project root do:

```bash
mvn clean test
```
