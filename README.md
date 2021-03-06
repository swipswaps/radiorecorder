Radio Recorder
===================
![Travis CI Status](https://travis-ci.org/sfuhrm/radiorecorder.svg?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

A command line internet radio player and recorder.
Some of the features are:
* Display of the current song title played.
* Playback using Java Media Framework.
* Recording different files for different song titles.
* Writing of ID3 tags (ID3v1 and ID3V2.4).
* Chromecast replay of radio streams.
* Parallel recording of multiple radio stations.

## Downloading & installation

The current version can be downloaded for Debian and Fedora systems here:

https://github.com/sfuhrm/radiorecorder/releases

## Usage

The program is a command line only program. It supports multiple parameters:

     URLORNAME           : URLs of the internet radio station(s) or station name
                           for lookup at http://www.radio-browser.info/
     -cast (-c) VAL      : Stream to the given chrome cast device.
     -directory (-d) DIR : Write to this directory. (default: USER-HOME)
     -help (-h)          : Show this command line help. (default: true)
     -list-cast (-L)     : List chromecast devices. (default: false)
     -min-free (-M) MEGS : Minimum of free megs on target drive. (default: 512)
     -play (-p)          : Play live instead of recording to a file. (default:
                           false)
     -reconnect (-r)     : Automatically reconnect after connection loss. (default:
                           false)
     -timeout (-T) SECS  : Connect/read timeout in seconds. (default: 60)
     -use-songnames (-S) : Use songnames from retrieved metadata information. Will
                           create one file per detected song. (default: false)


## License

Copyright 2017 Stephan Fuhrmann

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
