## Description

Spin up a running Datomic Free box from the commandline. Done.

TODO

## Usage

Let's deploy a datomic box to EC2!

```sh
$ git clone git@github.com:cldwalker/datomic-box.git; cd datomic-box

# EC2 credentials
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

To open up datomic ports to use from your dev machine:

* Select the datomic-box security group under the [Security Groups
  section](https://console.aws.amazon.com/ec2/home#s=SecurityGroups) of your EC2 dashboard.
* On the Inbound tab, create a new TCP rule for ports 4334-4336.
* Use Source 0.0.0.0/0 to have it available everywhere. You'll want to change this to something more
  restrictive once you can hit your transactor.
* Click 'Apply Rule Changes'

You should now be able to access your transactor with uri:
`datomic:free://IP-ADDR-OR-DOMAIN/DATABASE`

TODO

## Bugs/Issues

Please report them [on github](http://github.com/cldwalker/datomic-box/issues).

## License

See LICENSE.TXT

## TODO
* Provide a lein command to generate a pallet.clj in a project.
* Create a datomic box with `lein pallet up`.
* Open up configs of all crates
