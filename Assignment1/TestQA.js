const chai = require (`chai`);
const expect = require (`chai`).expect;
const chaiHttp = require ("chai-http");

require(`dotenv`).config();

chai.use(chaiHttp);

const api = chai.request(process.env.BASE_URL);

describe(`QA Test Dana`, function() {
    it(`Success Post`, function(done) {
        api.post(`/public/v2/users`)
        .set(`Authorization`, `Bearer cb6f93016fc73e4be4a1b8763964274410564dc05c5630fc2cfffea9b3b14735`)
        .send({
            email: `TestQADana@gmail.com`,
            name: `TestQADana`,
            gender: `male`,
            status: `active`
        })
        .end(function (error, response) {
            expect(response.status).to.equals(201)
            expect(response.body).to.be.an(`object`)
            expect(response.body).to.have.property(`id`)
            global.id = response.body.id
            expect(response.body).to.have.property(`email`)
            expect(response.body.email).to.be.equal(`TestQADana@gmail.com`)
            expect(response.body).to.have.property(`name`)
            expect(response.body.name).to.be.equal(`TestQADana`)
            expect(response.body).to.have.property(`gender`)
            expect(response.body.gender).to.be.equal(`male`)
            expect(response.body).to.have.property(`status`)
            expect(response.body.status).to.be.equal(`active`)
            done();
        })
    })
    it(`Success Get`, function(done) {
        api.get(`/public/v2/users/` + global.id)
        .set(`Authorization`, `Bearer cb6f93016fc73e4be4a1b8763964274410564dc05c5630fc2cfffea9b3b14735`)
        .end(function (error, response) {
            expect(response.status).to.equals(200)
            expect(response.body).to.be.an(`object`)
            expect(response.body).to.have.property(`id`)
            expect(response.body.id).to.be.equal(global.id)
            expect(response.body).to.have.property(`email`)
            expect(response.body.email).to.be.equal(`TestQADana@gmail.com`)
            expect(response.body).to.have.property(`name`)
            expect(response.body.name).to.be.equal(`TestQADana`)
            expect(response.body).to.have.property(`gender`)
            expect(response.body.gender).to.be.equal(`male`)
            expect(response.body).to.have.property(`status`)
            expect(response.body.status).to.be.equal(`active`)
            done();
        })
    })
    it(`Success Update`, function(done) {
        api.put(`/public/v2/users/` + global.id)
        .set(`Authorization`, `Bearer cb6f93016fc73e4be4a1b8763964274410564dc05c5630fc2cfffea9b3b14735`)
        .send({
            email: `TestQADanaUpdate@gmail.com`,
            name: `TestQADanaUpdate`,
            status: `inactive`,
            gender: `female`
        })
        .end(function (error, response) {
            expect(response.status).to.equals(200)
            expect(response.body).to.be.an(`object`)
            expect(response.body).to.have.property(`id`)
            expect(response.body.id).to.be.equal(global.id)
            expect(response.body).to.have.property(`email`)
            expect(response.body.email).to.be.equal(`TestQADanaUpdate@gmail.com`)
            expect(response.body).to.have.property(`name`)
            expect(response.body.name).to.be.equal(`TestQADanaUpdate`)
            expect(response.body).to.have.property(`gender`)
            expect(response.body.gender).to.be.equal(`female`)
            expect(response.body).to.have.property(`status`)
            expect(response.body.status).to.be.equal(`inactive`)
            done();
        })
    })
    it(`Success Delete`, function(done) {
        api.delete(`/public/v2/users/` + global.id)
        .set(`Authorization`, `Bearer cb6f93016fc73e4be4a1b8763964274410564dc05c5630fc2cfffea9b3b14735`)
        .end(function (error, response) {
            expect(response.status).to.equals(204)
            done();
        })
    })
})