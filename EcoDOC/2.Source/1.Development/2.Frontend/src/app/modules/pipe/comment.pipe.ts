import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'documentCommentPipe'
})
export class DocumentCommentPipe implements PipeTransform {

  transform(comment: string): string {
    console.log('comment', comment)
    if (comment == "undefined") {
      return ''
    }
    else return comment
  }
}
