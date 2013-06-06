## Description

Spin up a running Datomic Free box from the commandline. Done.

TODO

## Usage

Let's deploy a datomic box to EC2!

```sh
$ git clone git@github.com:cldwalker/datomic-box.git; cd datomic-box

# add EC2 credentials
$ lein pallet add-service aws aws-ec2 ACCESS_KEY_ID SECRET_ACCESS_KEY

# Create the box and install all packages
$ lein pallet up --phases configure,install
# To see how it's progressing tail the log file e.g. tail -f logs/target-IP-ADDR.log

# Manual steps that I hope to automate
$ ssh user@IP-ADDR
# On the box
$ sudo initctl start datomic
```

You know have a datomic-free transactor running as an upstart job!

At this point, there are multiple paths you could take:

* For just a personal app, you could [connect to the transactor from your computer](#connect-to-public-transactor).
* To run the personal app on EC2, [run it on the same box](#run-a-public-datomic-app).
* For a more robust setup, you could hook this transactor up to other EC2 peers as discussed
  [on this thread](https://groups.google.com/forum/#!topic/datomic/wBRZNyHm03o). You may want to
  consider using (CloudFormation)[http://docs.datomic.com/aws.html) and Datomic Pro.

## Connect to Public Transactor

To open up datomic ports for use from your machine:

* Select the datomic-box security group under the [Security Groups
  section](https://console.aws.amazon.com/ec2/home#s=SecurityGroups) of your EC2 dashboard.
* On the Inbound tab, create a new TCP rule for ports 4334-4336.
* Use Source 0.0.0.0/0 to have it available to anyone. To just allow your computer, put [your
  IP](https://www.google.com/search?q=what+is+my+ip) in this format: IP-ADDR/32
* Click 'Apply Rule Changes'
* Verify the ports are open: `telnet IP-ADDR PORT`

You should now be able to access your transactor with uri:
`datomic:free://IP-ADDR-OR-DOMAIN/DATABASE`

## Run a Public Datomic App

TODO

## Bugs/Issues

Please report them [on github](http://github.com/cldwalker/datomic-box/issues).

## License

See LICENSE.TXT

## TODO
* Provide a lein command to generate a pallet.clj in a project.
* Create a datomic box with `lein pallet up`.
* Open up configs of all crates
