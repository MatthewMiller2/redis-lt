## Basics
Strings are generic data up to 512M
```
PING
SET das "databases and search"
GET das
TYPE das
STRLEN das
GETRANGE das 0 10
GETSET das "new string"
GET das
DEL das
```

## Lists
```
LPUSH chapter "matt"
LRANGE chapter 0 -1
LPUSH chapter "austin"
LPUSH chapter "ramsey"
LPUSH chapter "ben"
LRANGE chapter 0 -1
RPUSH chapter "arun"
LRANGE chapter 0 -1
LPOP chapter
LRANGE chapter 0 -1
LINSERT chapter BEFORE matt "zoe"
LRANGE chapter 0 -1
DEL chapter
```

## Sets
Sets are just unordered collections of course. In redis,
possible to add, remove, and test for existence
in constant O(1) time
```
SADD das ben
SADD das zubair
SADD das mousumi
SMEMBERS das
SADD das ben
SMEMBERS das
SISMEMBER das zubair
SADD ads zoe
SADD ads richard
SADD ads austin
SUNION das ads
DEL ads
DEL das
```

## Hashes
```
HMSET tribes das "appian data" ads "appian data"
HGETALL tribes
HSET tribes "t&i" "engineering infrastructure"
HGETALL tribes
HGET tribes ads
HEXISTS tribes kdm
DEL tribes
```

## Publish/subscribe
```
SUBSCRIBE channel
```
```
PUBLISH channel "hello!"
PUBLISH channel "this is matt"
```
