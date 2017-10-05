union AnuncioID {

1: i64 id;
}
union UserID {
1: string id;
}
struct PublicacionEdge {
1: required AnuncioID anuncio_id;
2: required UserID user_id;
}

union AnuncioPropertyValue {
1: i64 views;
2: i64 date;
3: string section;
}

struct AnuncioProperty {
1: required AnuncioID id;
2: required AnuncioPropertyValue property;
}

union DataUnit {
1: AnuncioProperty anuncio;
2: PublicacionEdge publicacion;
}

struct Pedigree {
1: required i64 timestamp;
}

struct Data {
1: required Pedigree pedigree;
2: required DataUnit dataunit;
}
