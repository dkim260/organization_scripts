$command = 'youtube-dl'

$names = (Get-Content -Path .\list.txt) 

#$names | ForEach-Object -Process {$command='youtube-dl'+' '+$_ ; Write-Host $command}
#$names | ForEach-Object -Process {$command='youtube-dl'+' "' +$_+'" ' ; Write-Host $command}


                                  #set up command        starting quotation    url           closing quotation   extract flag      execute command
$names | ForEach-Object -Process {$command='youtube-dl'+' "'                  +$_          +'"'                 +'-x'             ;iex $command}