import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
    name: 'callback',
    pure: false
})
export class FilterCallbackPipe implements PipeTransform {
    transform(items: any[], callback, input): any {
        if (!items || !callback || !input || input == undefined) {
            return items;
        }
        return items.filter(item => {
            return callback(item, input);
        });
    }
}