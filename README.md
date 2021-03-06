# [MiG Layout](http://www.miglayout.com/) Manager for [GXT 3](http://www.sencha.com/products/gxt)

[![Build Status](https://api.travis-ci.org/hwestphal/gxt3-miglayout.svg?branch=master)](https://travis-ci.org/hwestphal/gxt3-miglayout)

See http://hwestphal.github.io/gxt3-miglayout/ for a demo application.

MigLayout and MigLayout examples © Mikael Grev, MiG InfoCom AB

MigLayout for GXT 3 uses Sencha GXT 3 which is distributed under the terms of the GPL v3 (http://www.sencha.com/products/gxt/license/)

## How to build

    > git clone https://github.com/hwestphal/gxt3-miglayout.git
    > cd gxt3-miglayout/gxt3-miglayout
    > mvn clean install
  
## How to use in your project

Add the following dependencies to your project (additionally to GWT and GXT):

    <dependencies>
        <dependency>
            <groupId>com.github.hwestphal</groupId>
            <artifactId>gxt3-miglayout</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>com.github.hwestphal</groupId>
            <artifactId>gxt3-miglayout</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <classifier>sources</classifier>
            <scope>provided</scope>
        </dependency>
    </dependencies>

Add the following entry to your GWT module descriptor:

    <inherits name='net.miginfocom.layout.MigLayout' />

You can now use `net.miginfocom.layout.gxt3.MigLayoutContainer` in your application. Please see the example application for details.
