# Camel Runner

## Update xml.yml from old version

### setHeader
"headerName" attribute becomes "name"

### consumer.delay
"consumer.delay" becomes "delay"

### \<method beanType="org.apache.camel.component.mail.TempAttachSplitter"/>
\<method beanType="org.apache.camel.component.mail.TempAttachSplitter"/> becomes \<method beanType="org.apache.camel.component.mail.SplitAttachmentsExpression"/>

### javaScript tag becomes js

### aggregate
- completionSize becomes a parameter
- "strategyRef" parameter becomes "aggregationStrategy"

### Remove all calls to JSHelper
replace helper(curtime,$format) with curtime.toString($format)

### Remove all "request"
"request" no longer exists in javascript code

### http4 becomes http

## Never Used:
- route id="KibanaInsertor"