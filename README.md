# ConfirmButton

## Features
 <img src="http://a3.qpic.cn/psb?/V11nMvcA1OpCIy/pupDHtaOh37MysaJEqarGIE00QatRV5uMqMyih46p0Q!/b/dBwBAAAAAAAA&bo=gAKRAwAAAAACMgY!&rf=viewer_4" width="49%">


## How to use
If you want use this library, you have to download this project, import it into your workspace and add the project as a library in your android project settings.

## Usage
Just do what you need to do when you are using a button
```
<com.chenyuwei.confirmbutton.ConfirmButton
      android:id="@+id/btnConfirm"
      android:layout_width="match_parent"
      android:layout_height="50dp"
      android:background="#02c754"
      android:orientation="vertical" />
```

## API

Type | Name | Param | Description
----|------|----|----|
void | setCurrentState(int) | <br>ConfirmButton.STATE_CONFIRM <br/> ConfirmButton.STATE_DONE | set current state
void | setConfirmText(String) | | set text to be dispaly on state confirm
void | setDoneText(String) |  | set text to be dispaly on state done

