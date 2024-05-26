````
show dbs

use test

db.employees.insertOne({
    name: "lake",
    age: 21,
    dept: "Database",
    joinDate: new ISODate("2022-10-01"),
    salary: 400000,
    bouns: null
})

db.employees.find()

db.employees.insertMany([
    {
        name: "ocean",
        age: 45,
        dept: "Network",
        joinDate: new ISODate("1999-11-15"),
        salary: 400000,
        resignationDate: new ISODate("2002-12-23"),
        bouns: null
    },
    {
        name: "river",
        age: 34,
        dept: "DevOps",
        isNegotiationg: true
    },
])

/* insert 속도 차이 테스트 */
for (i = 0; i < 300; i++) {
    db.insertTest.insertOne({a: i})
}
//[2024-05-26 21:36:58] completed in 6 s 2 ms

//2개 이상의 데이터 insert 시 insertMany 사용하는게 빠름
var docs = [];
for (i = 0; i < 300; i++) {
    docs.push({a: i})
}
db.insertTest.insertMany(docs)

//update 구문
db.employees.updateOne(
    {name: "river"}, //QueryFilter(조건절)
    {
        //수정 구문
        $set: {
            salary: 350000,
            dept: "Database",
            joinDate: new ISODate("2022-12-31")
        },
        //특정 필드 삭제
        $unset: {
            isNegotiationg: ""
        }
    }
)

select * from employees where name = "river";

//여러 필드 update
db.employees.updateMany(
    { resignationDate: {$exists: false }, joinDate: {$exists: true } },
    { $mul: {salary: Decimal128("1.1")} }
)

db.employees.updateMany(
    { resignationDate: {$exists: false }, bouns: null },
    { $set: {bouns: 100000} }
)

db.employees.updateOne(
    { name: "river" },
    { $unset: {bouns: ""}}
)

db.employees.updateMany(
    { resignationDate: {$exists: false }, bouns: {$exists: true} },
    { $set: {bouns: 100000} }
)

db.employees.deleteOne({name: "river"})

db.employees.deleteMany({})


db.planets.findOne({name: "Mars"})


db.planets.find({
    hasRings: true,
    orderFromSun: {$lte: 6}
})

// and 조건으로 표현 시
db.planets.find({
    $and: [
        { hasRings: true},
        {orderFromSun: {$lte: 6}}
    ]
})