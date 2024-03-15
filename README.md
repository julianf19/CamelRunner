# Camel Runner

## Update xml.yml from old version

### setHeader
"headerName" attribute becomes "name"

### consumer.delay
"consumer.delay" becomes "delay"

### \<method beanType="org.apache.camel.component.mail.TempAttachSplitter"/>
\<method beanType="org.apache.camel.component.mail.TempAttachSplitter"/> becomes \<method beanType="org.apache.camel.component.mail.SplitAttachmentsExpression"/>

### javaScript tag becomes js

### add subfolder to bean definition
class="helper.Aggregators.ArrayListAggregationStrategy" instead of: class="helper.ArrayListAggregationStrategy"
class="helper.JSHelper.JSHelper" instead of: class="helper.JSHelper" 

### Remove all calls to JSHelper
replace helper(curtime,$format) with curtime.toString($format)

### http4 becomes http

## Never Used:
- route id="KibanaInsertor"