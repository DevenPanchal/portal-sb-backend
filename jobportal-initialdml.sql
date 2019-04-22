INSERT INTO `jobportal`.`job`
(`jobid`,
`title`,
`description`,
`keywords`,
`location`,
`salaryrange`,
`postedby`,
`image`,
`userid`)
VALUES
(1,
"Sr. Software Engg",
"SSE @ Amazon",
"Java",
"Seattle",
"140000",
"bhima",
"www.wix.com/images/someimage.png",
null);

INSERT INTO `jobportal`.`user`
(`userid`,
`username`,
`email`,
`name`,
`location`,
`photo`,
`resume`,
`skills`,
`hashedpassword`,
`role`,
`education`,
`jobid`)
VALUES
(34,
"BLee",
"bl@aol.com",
"Bruce Lee",
"Seattle",
"https://static1.squarespace.com/static/574dd66227d4bdb54a2f65e3/t/5ab57ee388251b2e6b2f6a74/1525457744682/BL_Website_ETD_rt_profile_store_v1.jpg?format=500w",
"blahblahblah",
"java, microservices, sql",
"blahblahblah",
"user",
"MS",
1);
